using Library;

namespace SingleThread
{
   public  delegate void d();
    interface ISaver
    {
        void SaveAsync(Pendulum pend);
        
        event d Done ;
    }
}
