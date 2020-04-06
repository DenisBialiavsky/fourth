using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SingleThread
{
    class PendulumBuildManager
    {
        IPendulumBuilder Builder;
        public PendulumBuildManager(IPendulumBuilder builder)
        {
            Builder = builder;
        }

        public Pendulum Produce(float l, float a, float g)
        {
            return Builder.
                BuildA(a).
                BuildLength(l).
                BuildAcceleration(g).
                BuildMaxAlpha().
                BuildT().
                Build();
        }
    }
}
