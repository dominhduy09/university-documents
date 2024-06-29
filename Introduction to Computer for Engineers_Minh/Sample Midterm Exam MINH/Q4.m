% Question 4
function Q4()
% function to calculate the approximation of pi
    clc;
    N = input('Enter an integer: ');
    sum_pi = 0;
    for n = 0 : N
        sum_pi = sum_pi + 16^(-n)*(4/(8*n+1) - 2/(8*n+4) - 1/(8*n+5) - 1/(8*n+6));
    end
    fprintf('Value of pi with N = %d: %.20f\n', N, sum_pi);
end
