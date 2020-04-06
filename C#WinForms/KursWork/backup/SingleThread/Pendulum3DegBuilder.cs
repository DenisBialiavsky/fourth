using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SingleThread
{
    class Pendulum3DegBuilder : IPendulumBuilder
    {
        public Pendulum3DegBuilder()
        {
            pendulum = new Pendulum();
        }

        public override IPendulumBuilder BuildT()
        {
            pendulum.T = 2 * (float)(Math.PI * Math.Sqrt(pendulum.Length / pendulum.Acceleration));
            return this;
        }
    }
}
