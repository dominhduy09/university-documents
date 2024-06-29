clear all; close all; clc;

% FOR-LOOPS
x = -10:0.01:10;
for i = 1:length(x)
     y(i) = sub_Part3_Prob2(x(i));
end
plot(x,y)
 
% INDICATOR FUNCTIONS
x = -10:0.01:10;
fx=(3.*x.^2-x).*(x<-6)+(sqrt(7-x)).*((x>=-6)&(x<=5))+(8*x-3).*(x>5);
plot(x,fx)