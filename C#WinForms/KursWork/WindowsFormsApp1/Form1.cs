using System;
using System.Drawing;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        Pendulum pend = new Pendulum(9f);//Маятник с длиной нити 6м
        public Form1()
        {
            InitializeComponent();
            pend.Oscillate += pend_Oscillate;
            button1.Click += btnStart_Click;
            this.Text = string.Format("Мат. маятник с длиной нити {0:g} м", pend.Length);
        }

        void btnStart_Click(object sender, EventArgs e)
        {
            pend.Start();
        }


        Bitmap bmp;
        void pend_Oscillate(object sender, OscillateEventArgs e)
        {
            float r = pictureBox1.ClientSize.Height / 10;//радиус круга, изображающего груз
            float h = pictureBox1.ClientSize.Height - r;//Длина маятника на экране
            PointF pt;
            if (bmp != null) bmp.Dispose();
            if (pictureBox1.Image != null) pictureBox1.Image.Dispose();
            bmp = new Bitmap(pictureBox1.ClientSize.Width, pictureBox1.ClientSize.Height);
            using (Graphics g = Graphics.FromImage(bmp))
            {
                g.TranslateTransform(bmp.Width / 2, 0);
                pt = new PointF(bmp.Width / 4 * e.Scale, 0);
                pt.Y = (float)Math.Sqrt(h * h - pt.X * pt.X);
                RectangleF rect = RectangleF.FromLTRB(pt.X - r, pt.Y - r, pt.X + r, pt.Y + r);
                g.DrawLine(Pens.Black, 0f, 0f, pt.X, pt.Y);
                g.FillEllipse(Brushes.CornflowerBlue, rect);
            }
            pictureBox1.Image = bmp;
            Application.DoEvents();
        }

    }
}
