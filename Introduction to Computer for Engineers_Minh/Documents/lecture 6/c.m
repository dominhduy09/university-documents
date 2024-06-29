clear all
close all
clc

%plot function
x= -2:0.01:2;
% define function f(x)
fx= @(x) (x.^3-3*x+1);
y =fx(x);
% define function f(x)
df = @(x) (3*x.^2-3);
%calculate value fx on the interval [-2,2]
y =fx(x);
%define 1000 steps to iterate
N=1000;
%define a varible to check the roots condition
isroot = 0;
%define error
err=0.001;
%define interval [a,b]
a=-2;
b=2;
x0=2;
%check the necessary condition
if fx(a)*fx(b) <= 0
%loop start here with N steps
for k=1:N
  if abs(fx(x0))<= err;
    isroot = 1;
    rootis = x0;
    break;
  endif
  if df(x0)==0
    x0=rand;
  endif
  x1=x0-fx(x0)/df(x0);
  x0=x1;
end
endif
%plotting
plot(x,y,'r-',"linewidth",2)
if isroot == 1
    fprintf("Root Found %f\n", x0);
    hold on;
    plot(x0, fx(x0), 'db', 'Markersize', 20);
    hold on;
   plot([x0, x0], [-2, 6], '--o', 'LineWidth', 2);
end
axis([-2 2 -2 6])
grid on
title('Nguyen Dao Anh Khoi - Function {f_1(x) =x^3-3*x+1}')
ylabel('Function f_1(x)');
xlabel('x axis (unit 0.01 increment)');

