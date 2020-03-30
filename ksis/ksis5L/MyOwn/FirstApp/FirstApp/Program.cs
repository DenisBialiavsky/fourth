using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FirstApp
{
    delegate void AccountStateHandler(string message);

    class Account
    {
        int sum;
        AccountStateHandler _del;

        public void registerHandler(AccountStateHandler del)
        {
            _del += del;
        }

        public void UnRegisterHandler(AccountStateHandler del)
        {
            _del -= del;
        }

        public Account(int sum)
        {
            this.sum = sum;
        }

        public void Put(int sum)
        {
            this.sum += sum;
            if(_del!=null)
            _del("Puted " + sum);
        }

        public void Withdrow(int sum)
        {
            
            if (this.sum >= sum)
            {
                this.sum -= sum;
                if (_del != null)
               _del("Withdrowed " + sum);
            }
            else
            {
                if (_del != null)
                _del("Quite a dit ");
            }
           
        }
    }

    class Program
    {
        delegate void Message();
        delegate int Operation(int x,int y);

        static void Main(string[] args)
        {

            Account account =new  Account(100);
            account.registerHandler(Display);
            account.registerHandler(ColorDisplay);
            account.Put(32);
            account.Withdrow(45);
            account.UnRegisterHandler(Display);
            account.Withdrow(450);

            DoOperation(3, 6, Multiplay);
            DoOperation(3, 6, Add);

           /* Message message;
            message = new Message(Display);
            message.Invoke();
            message();

            Operation operation = Add;
            Console.WriteLine(operation.Invoke(3, 09));

            operation = Multiplay;
            Console.WriteLine(operation.Invoke(3, 09));*/

            Console.ReadLine();
        }

        static void DoOperation(int a, int b , Operation f){
            Console.WriteLine(f(a, b));
        }

        static int Add(int x, int u)
        {
            return x + u;

        }

        static int Multiplay(int x, int u)
        {
            return x * u;

        }

        static void Display(string message)
        {
            Console.WriteLine(message);
        }

        static void ColorDisplay(string message)
        {
            Console.ForegroundColor =ConsoleColor.Red;
            Console.WriteLine(message);
            Console.ResetColor();
        }
    }
}
