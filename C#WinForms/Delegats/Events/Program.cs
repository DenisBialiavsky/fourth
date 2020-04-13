using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Events
{
    class Program
    {
        static void Main(string[] args)
        {
            Counter count = new Counter();
            Handler_I h_i = new Handler_I();
            Handler_II h_ii = new Handler_II();

            count.onCount += h_i.Message;
            //count.onCount += h_ii.View;

            count.Count();
            Console.ReadLine();
        }
    }
   
    class Counter
    {
        public event EventHandler onCount;
        public void Count()
        {  
            for(int i = 0; i<100; i++)
            {
                if (i == 71 && onCount!=null)
                {
                    onCount(this, new EventArgs());
                }
            }
        }
    }

    class Handler_I
    {
        public void Message(Object o, EventArgs y)
        {
            Console.WriteLine("Handler_I");
    
        }
    }
    class Handler_II
    {
        public void View()
        {
            Console.WriteLine("Handler_II");
        }
    }
}
