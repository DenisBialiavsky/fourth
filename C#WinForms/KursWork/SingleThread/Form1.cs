using System;
using System.Windows.Forms;

namespace SingleThread
{
    public partial class Form1 : Form
    {

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            float l = float.Parse(textBox1?.Text), a = float.Parse(textBox2?.Text),
                g = float.Parse(textBox3?.Text), maxAlpha = (float)Math.Asin(a / (2 * l));
            PendulumBuilder builder;
            if (maxAlpha <= 0.0524)
            {
                builder = new Pendulum3DegBuilder();
            }
            else
            {//question
                builder = maxAlpha <= 1 ? new Pendulum60DegBuilder() : (PendulumBuilder)new Pendulum90DegBuilder();
            }
            PendulumBuildManager manager = new PendulumBuildManager(builder);
            Pendulum pend = manager.Produce(l,a,g);

            Drawer d = new Drawer(pend, pictureBox1);
            Processor.Process(pend, pictureBox1);
            d.Draw();
        }

        private void userManualToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start(
                "C:\\Users\\Asus\\Documents\\HelpNDoc\\Output\\chm\\Pendulum.chm");
        }
    }
}
