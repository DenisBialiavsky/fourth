using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library
{
    public class Pendulum60DegBuilder : PendulumBuilder
    {
        public Pendulum60DegBuilder()
        {
            pendulum = new Pendulum();
        }

        public override PendulumBuilder BuildT()
        {
            pendulum.T = 2 * (float)(Math.PI * Math.Sqrt(pendulum.Length / pendulum.Acceleration));
            pendulum.T *=(float) (1 + 0.25 * Math.Sin(pendulum.MaxAlpha / 2));
            return this;
        }
    }
}
