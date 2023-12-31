% Generate and plot the pdf of uniform variables
clear all; close all; clc;

% Generate 10^6 datas with uniform distribution from 0 to 1
x = 2*rand(1,10^6)-1;
% x = (b-a)*rand(1,L) + a; % Generate L uniform distributed variables from the range [a, b];
% Use histogram to get the plot of distribution
nbins = 100;
histogram(x,nbins)
[h, x_axis_vec] = hist(x,nbins);
area = trapz(x_axis_vec,h);
% 2/nbins*sum(h)
pdf = h/area;
figure
bar(x_axis_vec,pdf)
ylim([0 0.6]); xlim([-1.2,1.2])