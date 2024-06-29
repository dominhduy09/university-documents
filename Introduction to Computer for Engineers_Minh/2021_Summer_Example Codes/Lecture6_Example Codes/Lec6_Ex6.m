% This code is to compute the square-root algorithm
% The requirement is to get all values of sequences 
% such as the error |x(n)-x(n-1)|/|x(n-1)| < 10^(-6) 
% Hint: get x_vec = [x(1),....,x(n)] and use while-loop

clear all; close all; clc;
a = 20;
n = 2; x_vec = [20]; 
while n > 0
    x_vec = [x_vec sub_func_Ex6(n,a)];
    error = abs(sub_func_Ex6(n,a) - sub_func_Ex6(n-1,a))/abs(sub_func_Ex6(n-1,a));
    if error < 10^(-10)
        break;
    else
        n = n + 1;
    end
end
plot(1:length(x_vec), x_vec)
