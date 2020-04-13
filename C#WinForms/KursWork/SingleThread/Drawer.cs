using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;
using Library;


namespace SingleThread
{
    public class Drawer
    {
        readonly Bitmap bmp;
        private int Time = 0;
        private Pendulum Pend;
        private PictureBox PictureBox1;
        public System.Windows.Forms.Timer Tmr { get; set; } = new System.Windows.Forms.Timer();

        public Drawer(Pendulum pend, PictureBox pictureBox1 , Label lable7)
        {
            Tmr.Interval = pend.Info.Interval;
            Pend = pend;
            PictureBox1 = pictureBox1;
            Tmr.Tick += (s, a) =>
            {
                bmp?.Dispose();
                PictureBox1.Image?.Dispose();
                PictureBox1.Image = new Bitmap(Pend.Info.Shots[Time]);
                lable7.Text = Math.Round( Pend.Info.Moments.ElementAt(Time).X, 4).ToString();
                if (Time++ == Pend.Info.NumberOfShots)
                    Time = 0;
                Application.DoEvents();
            };
        }

        public void Draw()
        {
            Tmr.Start();
        }
    }

}
