using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
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
            IPendulumBuilder builder = null;
            if (maxAlpha <= 0.0524)
            {
                builder = new Pendulum3DegBuilder();
            }
            else if (maxAlpha <= 1)
            {
                builder = new Pendulum60DegBuilder();
            }
            else
            {
                builder = new Pendulum90DegBuilder();
            }
            PendulumBuildManager manager = new PendulumBuildManager(builder);
            Pendulum pend = manager.Produce(l,a,g);
            Drawer d = new Drawer(pend, pictureBox1);
            d.Start();
        }

        private void userManualToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start(
                "C:\\Users\\Asus\\Desktop\\C#WinForms\\KursWork\\NewProject\\NewProject.chm");
        }
    }
}
