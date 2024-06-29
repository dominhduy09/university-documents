clear all
close all
clc

%plot function
x= -2:0.01:5;
% define function f(x)
%fx= @(x) (3.*x-2);
fx= @(x) (x.^2-x-2);
y =fx(x);
%define horizontal - x axis
y0=zeros(1,length(x));

%we divide the interval into N slice
N=100;
increment=(abs(-2)+5)/N;
xx=-2:increment:5;
%integration calculation
S=0;
for k=1:1:N
  S=S+0.5*increment*(fx(xx(k))+fx(xx(k+1)));
end
fprintf("Intergration value is %d",S)
plot(x,y,'b-',"linewidth",2)
hold on
plot(x,y0,'r-',"linewidth",2)
%plot the slice\
for k=1:1:length(xx)
hold on
plot([xx(k) xx(k)],[0 fx(xx(k))],'r--',"linewidth",2);
end
axis([-2 5 -10 fx(5)])
grid on
title('Nguyen Dao Anh Khoi - Function {f_1(x) =x.^2-x-2}')
ylabel('Function f_1(x)');
xlabel('x axis (unit 0.01 increment)');
