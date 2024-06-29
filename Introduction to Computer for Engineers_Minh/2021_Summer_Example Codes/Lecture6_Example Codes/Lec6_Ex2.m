% Some methods to compute S = 1 + 1/2^2 + 1/3^2 +...
clear all; close all; clc;

% Cumsum function
N=1:1000; S1 = cumsum(1./(N.^2)); S1(1000) 

% While-Loops
N=1000; k=1; S2=0;
while k<=N;
    S2=S2+1/k^2; k=k+1;
end
disp(S2)

% For-Loops
n=1000; S3 = 0;
for k=1:n
    S3=S3+1/k^2;
end
disp(S3)