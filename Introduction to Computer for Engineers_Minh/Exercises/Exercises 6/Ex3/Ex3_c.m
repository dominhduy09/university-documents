% Define the range for t
t = linspace(0, pi, 1000); % 1000 points between 0 and pi

% Calculate x and y using meshgrid
[x, y] = meshgrid(t);

% Calculate the functions
func1 = -sin(t);
func2 = sin(x) + cos(y);
func3 = sin(x) .* cos(y);
func4 = sin(x).^2 - cos(y).^2;

% Plot all four graphs in the same figure
figure;
subplot(2, 2, 1);
plot(t, func1);
title('-sin(t)');
xlabel('t');
ylabel('Function value');

subplot(2, 2, 2);
plot(t, func2);
title('sin(x) + cos(y)');
xlabel('x');
ylabel('Function value');

subplot(2, 2, 3);
plot(t, func3);
title('sin(x) * cos(y)');
xlabel('x');
ylabel('Function value');

subplot(2, 2, 4);
plot(t, func4);
title('sin^2(x) - cos^2(y)');
xlabel('x');
ylabel('Function value');

% Adjust the layout
sgtitle('Plot of Four Functions');

