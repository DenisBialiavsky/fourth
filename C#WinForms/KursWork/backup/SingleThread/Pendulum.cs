using System;
using System.Drawing;
using System.Threading;
using System.Windows.Forms;

namespace SingleThread
{
    public class Pendulum
    {
        internal protected float A { get; set; }

        protected internal float Length { get; set; }

        internal protected float MaxAlpha { get; set; }

        protected internal float T { get; set; }

        internal protected float Acceleration { get; set; }

        public Pendulum()
        {

        }

        public Pendulum(Pendulum pendulum)
        {
            A = pendulum.A;
            Length = pendulum.Length;
            T = pendulum.T;
            Acceleration = pendulum.Acceleration;
            MaxAlpha = pendulum.MaxAlpha;
        }


        public override string ToString()
        {
            return string.Format("Amplitude: {2} m; Length: {0} m; T: {1} s; " +
                "Acceleration: {3} m/s^2", Length, T, A, Acceleration);
        }

        public override bool Equals(object obj)
        {
            return obj is Pendulum pendulum &&
                   A == pendulum.A &&
                   Length == pendulum.Length &&
                   T == pendulum.T &&
                   Acceleration == pendulum.Acceleration;
        }

        public override int GetHashCode()
        {
            var hashCode = 875952873;
            hashCode = hashCode * -1521134295 + A.GetHashCode();
            hashCode = hashCode * -1521134295 + Length.GetHashCode();
            hashCode = hashCode * -1521134295 + T.GetHashCode();
            hashCode = hashCode * -1521134295 + Acceleration.GetHashCode();
            return hashCode;
        }
    }
}