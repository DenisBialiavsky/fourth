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

    class Drawer : Pendulum
    {
        private int time = 0;
        private System.Windows.Forms.Timer tmr;
        private PictureBox pictureBox1;
        Bitmap bmp;
        float r;
        float h;
        PointF pt;

        public Drawer(Pendulum pendulum, PictureBox p) : base(pendulum)
        {
            pictureBox1 = p;
            r = pictureBox1.ClientSize.Height / 10;
            h = pictureBox1.ClientSize.Height - r - 100;
            tmr = new System.Windows.Forms.Timer
            {
                Interval = 20
            };
            tmr.Tick += (s, a)=>
            {
                double phase = ((Math.PI * 2) / T) * ((time++ * tmr.Interval) / 1000d);
                float X = A * (float)Math.Sin(phase);
                pend_Oscillate(X);
            };
        }

        internal void Start()
        {
            tmr.Start();
        }

        void pend_Oscillate(float X)
        {
            bmp?.Dispose();
            pictureBox1.Image?.Dispose();
            bmp = new Bitmap(pictureBox1.ClientSize.Width, pictureBox1.ClientSize.Height);
            float px1 = CountY(0, Length) / h;
            using (Graphics g = Graphics.FromImage(bmp))
            {
                g.TranslateTransform(bmp.Width / 2, 0);
                pt = new PointF(CountX(X, Length) / px1, CountY(X, Length) / px1);
                RectangleF rect = RectangleF.FromLTRB(pt.X - r, pt.Y - r, pt.X + r, pt.Y + r);
                g.DrawLine(Pens.Black, 0f, 0f, pt.X, pt.Y);
                g.FillEllipse(Brushes.CornflowerBlue, rect);
            }
            pictureBox1.Image = bmp;
            Application.DoEvents();
        }

        /*
         x: 3
         // This is an ERROR, as positional args are listed after named args.
         // This is OK, as positional args are listed before named args.
         out
         ref
         in
          static double CalculateAverage(params double[] values)
          {}
         */

        static float CountBetta(float x, float l = 8f)
        {
            float alpha = (float)Math.Asin(x / (2 * l)) * 2;
            return (float)(90 / 57.296) - alpha;
        }

        static float CountX(float x, float l) => l * (float)Math.Cos(CountBetta(x, l));

        static float CountY(float x, float l) => l * (float)Math.Sin(CountBetta(x, l));
    }

}
