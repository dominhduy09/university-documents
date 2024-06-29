% Recursive Functions of Fibonacci: f(n)=f(n-1)+f(n-2)

function y = fib(n)
   if n == 1
       y = 0;   % Create first initial value of Fib
   end
   if n == 2
       y = 1;   % Create second initial value of Fib
   end
   if n > 2
       y = fib(n-1) + fib(n-2);
   end
end