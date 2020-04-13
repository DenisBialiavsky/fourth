using Library;

namespace SingleThread
{
   public  delegate void tepmlate(string s);
    interface ISaver
    {
        void SaveAsync(Pendulum pend);
        
        event tepmlate Done ;
    }
}
