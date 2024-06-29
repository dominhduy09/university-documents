% Define the range for x
x = linspace(-pi, pi, 1000); % 1000 points between -pi and pi

% Calculate y = tan(sin(x)) - sin(tan(x))
y = tan(sin(x)) - sin(tan(x));

% Plot the graph
plot(x, y);

% Label the axes and title
xlabel('x');
ylabel('y = tan(sin(x)) - sin(tan(x))');
title('Plot of y = tan(sin(x)) - sin(tan(x))');

% Add grid
grid on;

