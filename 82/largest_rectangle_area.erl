-module(largest_rectangle_area).
-export([largest_rectangle_area/1]).

-define(DBG(X),io:format("~p~n", [X])).

%% # 84. Largest Rectangle in Histogram
%% # https://leetcode.com/problems/largest-rectangle-in-histogram/



-spec largest_rectangle_area(Heights :: [integer()]) -> integer().
largest_rectangle_area(Heights) ->
    {Stack, MPopRect} = lists:foldl(fun
        (N, {[], MaxPop}) ->
            {push([], N), MaxPop};

        (N, {Stack, MaxPopRect}) ->
            case Stack of
                [H|T] when H =< N ->
                    {push(Stack, N), MaxPopRect};
                _ ->
                    Pops = pop(Stack, N),
                    PopRect = max_pop_rect(Pops),
                    NStack = update_stack(Stack, N),
                    % ?DBG({Pops, PopRect, NStack}),
                    {push(NStack, N), max(PopRect, MaxPopRect)}
            end
    end, {[], 0}, Heights),
    max(max_pop_rect(Stack), MPopRect).




update_stack([], _N) ->
    [];

update_stack([{H, Ctr}|T], N) when H > N ->
    Stack = update_stack(T, N),
    lists:foldl(fun(_X, AccStack) ->
        push(AccStack, N)
    end, Stack, lists:seq(1, Ctr));

update_stack(Stack, _N) ->
    Stack.


max_pop_rect(Pops) ->
    lists:foldl(fun({N, Ctr}, Max) ->
        Rect = lists:sum([Ctr||{X, Ctr}<-Pops, X>=N]) * N,
        max(Max, Rect)
    end, 0, Pops).



pop([], N) ->[];
pop([{H, Ctr}|T], N) when H > N-> [{H, Ctr} | pop(T, N)];
pop(_Stack, N) ->[].


push([], I) -> [{I, 1}];
push([{I, N}|T], I) -> [{I, N+1}|T];
push(Stack, I) -> [{I, 1}|Stack].
