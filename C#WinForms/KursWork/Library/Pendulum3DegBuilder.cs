using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Library
{
    public class Pendulum3DegBuilder : PendulumBuilder
    {
        public Pendulum3DegBuilder()
        {
            pendulum = new Pendulum();
        }

        public override PendulumBuilder BuildT()
        {
            pendulum.T = 2 * (float)(Math.PI * Math.Sqrt(pendulum.Length / pendulum.Acceleration));
            return this;
        }
    }
}
