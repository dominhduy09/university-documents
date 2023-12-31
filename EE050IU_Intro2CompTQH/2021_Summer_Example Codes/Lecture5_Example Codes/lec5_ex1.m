% Practice to use indicator functions
clc; clear all; close all;

% Method 1
% x_vec = -2:0.001:2;
% unit_step_vec = []
% for ind = 1:length(x_vec)
%     x = x_vec(ind);
%     if x >= 0 
%         unit_step = 1;
%     else
%         unit_step = 0;
%     end
%     unit_step_vec = [unit_step_vec unit_step] ;
% end
% figure
% plot(x_vec, unit_step_vec,'x-b')

% Method 2
% x_vec = -2:0.001:2;
% unit_step_vec = (x_vec >= 0);
% figure
% plot(x_vec, unit_step_vec,'x-b')

% Method 3
% unit_step = @(x) (x >=0 );
% fplot(unit_step)

% For indicator functions
x_vec = -2:0.001:6;
a = 2; b =4;
indicator_vec = (x_vec >= a)&(x_vec < b);
figure
plot(x_vec, indicator_vec,'x-b')
