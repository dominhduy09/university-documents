clear all; close all; clc;

% Use FOR-LOOPS
x=-10:0.01:20;
for i=1:length(x)
    y(i)= sub_Part3_Prob1(x(i));
%     if x(i) > -5
%         y(i) = x(i)^2+8;
%     else
%         y(i) = (-x(i)^3)+2;
%     end
end
plot(x,y)

% USE Indicator function
x = -10:0.01:20;
fx = ((x.^2+8).*(x>-5))+((-x.^3+2).*(x<=-5));
plot(x,fx)