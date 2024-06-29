% Define the range for x
x = linspace(0, 2*pi, 1000); % 1000 points between 0 and 2*pi

% Calculate y = sin(x)
y = sin(x);

% Plot the graph
plot(x, y);

% Label the axes and title
xlabel('x');
ylabel('y = sin(x)');
title('Plot of y = sin(x)');

% Add grid
grid on;

