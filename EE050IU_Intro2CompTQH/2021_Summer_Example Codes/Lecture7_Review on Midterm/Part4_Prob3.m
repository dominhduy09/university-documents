clear all; close all; clc

x = input('Type the value of x (different from 0): ')
a = input('Type the value of a (different from 0): ')
S = 1;    % Khoi tao S(0)
n=1;
S(n)= S + (log(a))^n*x^n/factorial(n); 
while 1
    n = n + 1;
    S(n) = S(n-1) + (log(a))^n*x^n/factorial(n);
    error = abs(S(n) - S(n-1))/abs(S(n-1));
    if error < 10^(-6)
        break;
    end
end

fprintf('The value of a^x is %10.5f \n',S(n))
plot(1:n, S)