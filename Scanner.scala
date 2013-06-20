
object Scanner {

  val patt = new scala.util.matching.Regex("""(?xsmU)  # verbose,dotall,multiline,unicode
         (?<float>
                 \d*\.\d+(?:[eE][+-]?\d+)?        # float, dotted
                |\d+[eE][+-]?\d+                  # undotted, with 'e'
                )
        |(?<hexnum> 0x[0-9A-Fa-f]+)  # hex number
        |(?<number> \d+)       # number  TODO: there is no such thing in JS!
        |(?<ident>  [$\w]+)    # identifier, name
        |(?<nl>                # unicode line separators
                 \x0D\x0A
                #|\x20\x28      # strange: this is ' (' !?
                #|\x20\x29      # strange: this is ' )' !?
                |\x0A
                |\x0D
                )
        |(?<white> (?:(?:\s|\ufeff)(?<!\n))+)     # white ( + BOM - \n)
        |(?<mulop>         # multi-char operators
                 <<=?           # <<, <<=
                |>=             # >=
                |<=             # <=
                |===?           # ==, ===
                |!==?           # !=, !==
                |[-+*/%|^&]=    # -=, +=, *=, /=, %=, |=, ^=, &=
                |>>>?=?         # >>, >>>, >>=, >>>=
                |&&             # &&
                |[|^]\|         # ||, ^|
                |\+\+           # ++
                |--             # --
                |::             # ::
                |\.\.           # ..
                |//             # // (end-of-line comment)
                |/\*            # /* (start multi-line comment)
                |\*/            # */ (end multi-line comment)
                )
        |(?<op> \W)            # what remains (operators)
        """)

}
