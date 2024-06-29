clear all
close all
clc


##S = 1;  % Initialize S_0
##T = 1;  % Initialize T_0
##n = 1;  % Initialize n
##
##while abs(T) >= 1e-14
##    T = (-1)^n / (2 * n + 1)^(3 * n);
##    S = S + T;
##    n = n + 1;
##end

for i = 1:5
    fprintf('%4d',i*[1:i])
    fprintf('\n')
end

##N=100;
##n=0:1:100;
##
##S= sum((-1).^n./factorial((2*n+1)*(3.^n.)))
