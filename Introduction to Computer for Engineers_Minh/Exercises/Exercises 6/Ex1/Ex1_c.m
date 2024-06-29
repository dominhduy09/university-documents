% Initial balance
a = input('Enter the initial balance: ');

% Target balance
target_balance = 2 * a;

% Annual interest rate
annual_interest_rate = 0.10;

% Initialize variables
accumulated_amount = a;
years = 0;

% Loop until accumulated amount doubles initial balance
while accumulated_amount < target_balance
    % Calculate interest for the current year
    interest = annual_interest_rate * accumulated_amount;

    % Update accumulated amount
    accumulated_amount = accumulated_amount + interest;

    % Increment years
    years = years + 1;
end

% Display the number of years
fprintf('It takes %d years for the accumulated amount to double the initial balance.\n', years);

