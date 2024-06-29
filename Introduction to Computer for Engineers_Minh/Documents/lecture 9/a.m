clear all
close all
clc;

x1 = 0 :pi/40:2*pi;
x = 0 :pi/4:2*pi;
%we measure 8 points

v = sin(x);
v1 = sin(x1);

plot(x,v,'-');
hold on
plot(x1,v1,'o-');

 %we want to interpolate the value
 %at
 xq1 = pi/8:pi/4:2*pi;
 vq1= interp1(x,v,xq1,'linear');
%SPline interpolation

 vq2 = interp1(x,v,xq1,'spline');

% Plot xq1 and xq2
plot(xq1, vq1, 'kv', 'MarkerSize', 10);
plot(xq1, vq2, 'r^', 'MarkerSize', 10);

xlim([0 2*pi]);
title('(Default) Linear Interpolation', 'FontSize', 16);
grid on
xlim([0 2*pi]);
title('(Default) Linear Interpolation-Nguyen Dao Anh Khoi', 'FontSize', 16);
grid on



