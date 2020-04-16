using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace Client
{
    class Program
    {
        static void Main(string[] args)
        {
            // отправитель - устанавливаем адрес и отображаемое в письме имя
            MailAddress from = new MailAddress("somemail@gmail.com", "Tom");
            // кому отправляем
            MailAddress to = new MailAddress("varabeiivan@gmail.com");
            // создаем объект сообщения
            MailMessage m = new MailMessage(from, to);
            // тема письма
            m.Subject = "Тест";
            // текст письма
            m.Body = "<h2>Письмо-тест работы smtp-клиента</h2>";
            // письмо представляет код html
            m.IsBodyHtml = true;


            
            //
          /* TcpClient client = new TcpClient();
            client.Connect("localhost", 25);
            byte[] data = new byte[256];
            StringBuilder response = new StringBuilder();
            NetworkStream stream = client.GetStream();
            

            Console.WriteLine("Enter massege to send to server : ");
            string mesToServ = Console.ReadLine();
            data = Encoding.UTF8.GetBytes(mesToServ);
            stream.Write(data, 0, data.Length);*/

            // 
            
            SmtpClient smtp = new System.Net.Mail.SmtpClient("localhost");
            smtp.Send(m);//Handles all messages in the protocol
            smtp.Dispose();//sends a Quit message
            Console.Read();
        }
    }
}
