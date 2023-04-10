using Lightrun;

namespace HelloWorld
{

    class Program
    {
        static void Main(string[] args)
        {

            var watch = new System.Diagnostics.Stopwatch();

            LightrunAgent.Start(new AgentOptions {
                Secret = Environment.GetEnvironmentVariable("LIGHTRUN_KEY"),
                ServerUrl= new Uri("https://app.lightrun.com/"),
                // AlsoLogToStandardError=true,
                // VerbosityLevel = 1,
            });


            System.Threading.Thread.Sleep(15000);

            Console.WriteLine("Start Test");

            watch.Start();

            for (int i = 10; i < 1000; i++) {
                // Console.WriteLine("Checking i " + i);
                System.Threading.Thread.Sleep(5);
                FibonacciSeries(i);
            }
            watch.Stop();
            Console.WriteLine($"total time {watch.ElapsedMilliseconds} ms");
            
            System.Threading.Thread.Sleep(15000);

        }

        static int FibonacciSeries(int n)  
        {  
            System.Threading.Thread.Sleep(5);
            int firstnumber = 0, secondnumber = 1, result = 0;  
   
            if (n == 0) 
                return 0; //To return the first Fibonacci number   
            if (n == 1) 
                return 1; //To return the second Fibonacci number   

            firstnumber = n-1;
            secondnumber = n-2;
            result = FibonacciSeries(firstnumber) + FibonacciSeries(secondnumber);
            return result;
        } 
    }
}
