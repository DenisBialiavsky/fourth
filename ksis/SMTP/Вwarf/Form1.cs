using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Windows.Forms;
using System.IO;


namespace Dwarf
{
    public partial class Form1 : Form
    {
        static IPEndPoint endPoint = new IPEndPoint(IPAddress.Any, 25);
        TcpListener listener = new TcpListener(endPoint);
        int NumberOfClients;
        static Queue<string> logs = new Queue<string>();
        Thread writer;
        public Form1()
        {
            InitializeComponent();
            writer = new Thread(new ThreadStart(Write));
            writer.Start();
        }

        private async void button1_Click(object sender, EventArgs e)
        {
            listener.Start();
            button1.Enabled = false;
            button2.Enabled = true;
            groupBox1.Enabled = false;
            await Task.Run(() =>
             {
                 if (radioButton1.Checked == true)
                 {
                     while (true)
                     {
                         Action act = () => label1.Text = "" + NumberOfClients;
                         Invoke(act);
                         try
                         {
                             TcpClient client = listener.AcceptTcpClient();
                             SMTPServer handler = new SMTPServer(client);
                             handler.Detached += Mult ;
                             handler.Detached += Detach;
                             handler.Detached += Add;
                             Thread thread = new Thread(new ThreadStart(handler.Run));
                             thread.Start();
                             Attach();
                             NumberOfClients ++;
                         }
                         catch
                         {
                             return;
                         }

                     }
                 }
                 else
                 {
                     
                     try
                     {
                         TcpClient client = listener.AcceptTcpClient();
                         SMTPServer handler = new SMTPServer(client);
                         handler.Recived += Show;
                         handler.Detached += Mult;
                         handler.Detached += Detach;
                         Thread thread = new Thread(new ThreadStart(handler.Run));
                         thread.Start();
                         NumberOfClients++;
                         Action act = () => label1.Text = "" + NumberOfClients;
                         Invoke(act);
                     }
                     catch
                     {
                         return;
                     }
                 }
             });
        }

        void Mult(string s)
        {
            NumberOfClients--;
            Action act = () => label1.Text = "" + NumberOfClients;
            Invoke(act);
        }

        public void Show(string s)
        {
                Action action = () =>
                {
                    richTextBox1.AppendText(s);
                    richTextBox1.ScrollToCaret();
                };
                Invoke(action);
        }

        public void Attach()
        {
            Action action = () =>
            {
                richTextBox1.AppendText("New client has connected\n");
                richTextBox1.ScrollToCaret();
            };
            Invoke(action);
        }

        public void Detach(string s)
        {
            Action action = () =>
            {
                richTextBox1.AppendText("\nA client has detached\n");
                richTextBox1.ScrollToCaret();
            };
            Invoke(action);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            button2.Enabled = false;
            groupBox1.Enabled = true;
            button1.Enabled = true;
            listener.Stop();
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            button1.Enabled = true;
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            button1.Enabled = true;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            richTextBox1.Clear();
        }

        static void Add(string text)
        {
            text = "\nInception of connection->\n" + text + "\n<-End of connection\n";
            logs.Enqueue(text);
        }

        static void Write()
        {
            while (true)
            {
                if (logs.Count>0)
                {
                    string writePath = @"C:\fourth\ksis\SMTP\log.txt";
                    try
                    {
                        using (StreamWriter sw = new StreamWriter(writePath, true, Encoding.Default))
                        {
                            sw.WriteLine(logs.Dequeue());
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
                else
                {
                    Thread.Sleep(20);
                }
            }
        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            while (logs.Count > 0) { }
                writer.Abort();
        }
    }
}
