clear all
close all
clc

##%plot based on the record
##% x = 3, y = 4
##plot([3 3],[4 3],'-',"Markersize",20,"linewidth",5)
##hold on
##plot([5 4],[5 2],'-.s',"Markersize",20,"linewidth",5)
##%change the range of display
##%xmin xmax ymin ymax
##axis([0 5 0 5])
##
##grid on
##title('My first plotting {x_2^3}')
##ylabel("y axis (unit)")
##xlabel("x axox (unit)")
% Define the coordinates of the star vertices
x = [0, 0.3, 0.5, 0.7, 1, 0.7, 0.5, 0.3, 0, 0.5];
y = [1, 0.3, 0, 0.3, 1, 0.7, 0.3, 0, 0.3, 1];

% Plot the star
plot(x, y, '-o');
axis equal; % Set equal axis scaling for a more accurate representation
title('Star Plot');



