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
        public Moment(double phase, double x)
        {
            Phase = phase;
            X = x;
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
