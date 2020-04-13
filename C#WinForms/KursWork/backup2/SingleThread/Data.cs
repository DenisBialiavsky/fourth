using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SingleThread
{

    public class Moment
    {
        public double Phase;
        public double X;
        public double Time;
        public Moment(double phase, double x, double t)
        {
            Phase = phase;
            X = x;
            Time = t;
        }
    }
    public class Data
    {
        public Dictionary<int, Bitmap> Shots = new Dictionary<int, Bitmap>();
        public List<Moment> Moments = new List<Moment>();
        public int Interval { get; set; }

        public int NumberOfShots { get; set; }
    }
}
