clear all; close all; clc;

x = input('Input value of x: ');
n = 0;
RHS_vec=[]; RHS=0;
while n > -1 
    RHS = RHS + (x^n/factorial(n));
    RHS_vec = [RHS_vec RHS];
    if abs(RHS-exp(x)) < 10^(-6)
        break;
    else
        n=n+1;
    end
end
n_vec = 1:length(RHS_vec);
plot(n_vec,RHS_vec,'b')
