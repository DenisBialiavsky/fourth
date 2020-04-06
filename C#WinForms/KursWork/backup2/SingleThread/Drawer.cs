using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;
using System.Threading;


namespace SingleThread
{
    public class Drawer
    {
        readonly Bitmap bmp;
        private int time = 0;
        private System.Windows.Forms.Timer tmr;
        public Drawer(Pendulum pend, PictureBox pictureBox1)
        {
            tmr = new System.Windows.Forms.Timer
            {
                Interval = pend.Info.Interval
            };
            tmr.Tick += (s, a) =>
            {
                bmp?.Dispose();
                pictureBox1.Image?.Dispose();
                pictureBox1.Image = new Bitmap(pend.Info.Shots[time]);
                if (time++ == pend.Info.NumberOfShots)
                    time = 0;
                Application.DoEvents();
            };
        }

        public void Draw()
        {
            tmr.Start();
        }
    }

}
