clear all; close all; clc;

M = 18;
ti = [1:21];
Hi = [13 27 26 44 30 39 40 34 45 44 24 32 44 39 29 44 38 47 34 40 50];

% Find coefficients in polynomial form
p = polyfit(ti,Hi,M);
H = polyval(p,ti);
figure
plot(ti,Hi,'ok')
hold on; grid on;
plot(ti,H,'-b')

% Use these coefficients with other datas rather than xi
ti_new = linspace(1,21,150);
H_new = polyval(p,ti_new);
figure
plot(ti,Hi,'ok')
hold on; grid on;
plot(ti_new,H_new,'-b')