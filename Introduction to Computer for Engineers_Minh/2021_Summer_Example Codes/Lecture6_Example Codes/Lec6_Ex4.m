% Compute infinte sum S(n) = 1/1^2 + 1/2^2 +... + 1/n^2 when n goes to infinity 
% with the relative error |S(n) - S(n-1)|/|S(n-1)| < 10^(-10)
% Notice that S(n) - S(n-1) = 1/n^2

clear all; close all; clc;
S = 0; n = 1;
while n > 0
    error = (1/n^2)/S;
    if error < 10^(-10)
        break;
    else
        S = S + 1/n^2; 
        n = n + 1;  
    end    
end
S