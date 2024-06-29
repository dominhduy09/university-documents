% Initialize variables
sum = 0;
n = 0;

% Loop until the sum exceeds 1000
while sum < 1000
    % Increment n
    n = n + 1;

    % Add the square of n to the sum
    sum = sum + n^2;
end

% Since the loop breaks when sum exceeds 1000, decrement n by 1 to get the maximum value
n = n - 1;

% Display the maximum value of n
fprintf('The maximum value of n such that the expression is less than 1000 is: %d\n', n);

