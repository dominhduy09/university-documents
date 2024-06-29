% Initialize counters
even_count = 0;
odd_count = 0;

% Read 10 integers
for i = 1:10
    integer = input(['Enter integer ', num2str(i), ': ']);

    % Check if the integer is even or odd
    if mod(integer, 2) == 0
        even_count = even_count + 1;
    else
        odd_count = odd_count + 1;
    end
end

% Display the counts
disp(['Number of even integers: ', num2str(even_count)]);
disp(['Number of odd integers: ', num2str(odd_count)]);

