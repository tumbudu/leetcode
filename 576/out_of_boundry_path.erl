-spec find_paths(M :: integer(), N :: integer(), MaxMove :: integer(), StartRow :: integer(), StartColumn :: integer()) -> integer().
find_paths(M, N, MaxMove, StartRow, StartColumn) ->
    find_paths1(M, N, MaxMove, [{{StartRow, StartColumn}, 1}], 0).

find_paths1(M, N, Moves, KList, AccMoves) when Moves > 0->
    ProcessedList = process(KList),

    {ValidKeys, OBP} = lists:foldl(fun

        ({{R, C}, Ctr}, {Acc, AccMoves1}) when R < 0; C < 0; R >= M; C >= N ->
            {Acc, AccMoves1 + Ctr};

        ({{R, C},_Ctr}, {Acc, AccMoves1}) ->
            {[{R, C}|Acc], AccMoves1}

    end, {[], AccMoves}, ProcessedList),

    Keys = lists:usort(ValidKeys),

    KList1 = lists:map(fun(K) ->
        VList = proplists:get_all_values(K, ProcessedList),
        {K, lists:sum(VList)}
    end, Keys),

    find_paths1(M, N, Moves-1, KList1, OBP);

find_paths1(_M, _N, _Moves, _KList, AccMoves) ->
    AccMoves rem 1000000007.


process(Klist) ->

    lists:foldl(fun({{R, C}, Ctr}, Acc) ->

        Acc ++ [
        {{R - 1, C}, Ctr},
        {{R + 1, C}, Ctr},
        {{R, C + 1}, Ctr},
        {{R, C - 1}, Ctr}
        ]
    end, [], Klist).
