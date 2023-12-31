% S(n) = sum of (-1/3)^k/(2k+1) for k=0,1,2,..,n. 
% with the relative error |S(n) - S(n-1)|/|S(n-1)| < 10^(-10)
% Notice that S(n) - S(n-1) = (-1/3)^n/(2n+1)
% Plot S(n) versus n

clear all; close all; clc;
S_vec = [];
S = 0; k = 0;
while k > -1
    error = abs((-1/3)^k/(2*k+1))/abs(S);
    if error < 10^(-5)
        break;
    else
        S = S + (-1/3)^k/(2*k+1); 
        S_vec = [S_vec S];
        k = k + 1;          
    end    
end
n_vec = 0:length(S_vec)-1;
plot(n_vec,S_vec)
xlabel('n'); ylabel('S(n)')