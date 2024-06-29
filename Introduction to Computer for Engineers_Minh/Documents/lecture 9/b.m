clear all
close all
clc;

%we measure 6 points
%x - voltage (Volts)
x = [0 5 10 15 20 25];
%y - current (Ampe)
y = [0.001 0.881 2.1637 3.1827 0 4.961];
%matrix A
A= [ length(x) sum(x);
        sum(x) sum(x.^2)]
b= [sum(y); sum(x.*y)]
a = inv(A)*b
% calculate first order polynomial
%line that fit the dataset
yest = a(2,1)*x + a(1,1);

%sum of square of error
sum((y-yest).^2)

%use polyfit - hypothesis first order
apoly = polyfit(x,y,1)
%use polyfit - hypothesis second order
apoly2= polyfit(x,y,2)
yest2 = apoly2(1,3).*x.^2 + apoly2(1,2).*x + apoly2(1,1)
%plot dataset
plot(x,y,'ro','MarkerSize',6)
%plot first order polynomial that best
%to the dataset
hold on
plot(x,yest, 'b-','linewidth',2)
xlim([0 25]);
title('(Default) Linear Interpolation', 'FontSize', 16);
grid on
