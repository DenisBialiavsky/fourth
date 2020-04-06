using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SingleThread
{
   abstract class IPendulumBuilder
    {
        protected Pendulum pendulum;
        public IPendulumBuilder BuildA(float a)
        {
            pendulum.A = a;
            return this;
        }
        public IPendulumBuilder BuildLength(float l)
        {
            pendulum.Length = l;
            return this;
        }

        public IPendulumBuilder BuildAcceleration(float g = 9.8f)
        {
            pendulum.Acceleration = g;
            return this;
        }
        public IPendulumBuilder BuildMaxAlpha()
        {
            pendulum.MaxAlpha = (float)Math.Asin(pendulum.A / (2 * pendulum.Length));
            return this;
        }
        public abstract IPendulumBuilder BuildT();

        public Pendulum Build()
        {
            return pendulum;
        }
    }
}
