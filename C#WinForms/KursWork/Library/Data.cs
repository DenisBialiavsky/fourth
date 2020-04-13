using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library
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

        public override bool Equals(object obj)
        {
            return obj is Moment moment &&
                   Phase == moment.Phase &&
                   X == moment.X &&
                   Time == moment.Time;
        }

        public override int GetHashCode()
        {
            var hashCode = 1951886939;
            hashCode = hashCode * -1521134295 + Phase.GetHashCode();
            hashCode = hashCode * -1521134295 + X.GetHashCode();
            hashCode = hashCode * -1521134295 + Time.GetHashCode();
            return hashCode;
        }

    }
    public class Data
    {
        public Dictionary<int, Bitmap> Shots = new Dictionary<int, Bitmap>();
        public List<Moment> Moments = new List<Moment>();
        public int Interval { get; set; }

        public int NumberOfShots { get; set; }

        public override bool Equals(object obj)
        {
            return obj is Data data &&
                   EqualityComparer<Dictionary<int, Bitmap>>.Default.Equals(Shots, data.Shots) &&
                   EqualityComparer<List<Moment>>.Default.Equals(Moments, data.Moments) &&
                   Interval == data.Interval &&
                   NumberOfShots == data.NumberOfShots;
        }

        public override int GetHashCode()
        {
            var hashCode = 1050476186;
            hashCode = hashCode * -1521134295 + EqualityComparer<Dictionary<int, Bitmap>>.Default.GetHashCode(Shots);
            hashCode = hashCode * -1521134295 + EqualityComparer<List<Moment>>.Default.GetHashCode(Moments);
            hashCode = hashCode * -1521134295 + Interval.GetHashCode();
            hashCode = hashCode * -1521134295 + NumberOfShots.GetHashCode();
            return hashCode;
        }

    }
}
