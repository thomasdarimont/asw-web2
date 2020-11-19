package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Controller
class CalculationController {

    @GetMapping("/")
    public String showCalculators() {
        return "calc";
    }

    @GetMapping("/calc_get")
    public String showCalculatorWithGetPage() {
        return "calc_get";
    }

    @GetMapping("/calc_post")
    public String showCalculatorWithPostPage() {
        return "calc_post";
    }

    @GetMapping("/calculate")
    public String calculateViaGet( //
                                   @RequestParam(name = "n1") BigDecimal n1, //
                                   @RequestParam(name = "n2") BigDecimal n2, //
                                   @RequestParam(name = "op") Operation op, //
                                   Model model //
    ) {

        BigDecimal result = compute(n1, n2, op);

        model.addAttribute("n1", n1);
        model.addAttribute("n2", n2);
        model.addAttribute("op", op);
        model.addAttribute("resultGet", result);

        return "calc_get";
    }

    @PostMapping("/calculate")
    public String calculateViaPost( //
                                    @RequestParam(name = "n1") BigDecimal n1, //
                                    @RequestParam(name = "n2") BigDecimal n2, //
                                    @RequestParam(name = "op") Operation op, //
                                    Model model //
    ) {

        BigDecimal result = compute(n1, n2, op);

        model.addAttribute("n1", n1);
        model.addAttribute("n2", n2);
        model.addAttribute("op", op);
        model.addAttribute("resultPost", result);

        return "calc_post";
    }

    private BigDecimal compute(BigDecimal n1, BigDecimal n2, Operation op) {

        if (n1 == null || n2 == null || op == null) {
            return null;
        }

        switch (op) {

            case PLUS:
                return n1.add(n2);

            case MINUS:
                return n1.subtract(n2);

            case MULTIPLY:
                return n1.multiply(n2);

            case DIVIDE:
                return n1.divide(n2, MathContext.DECIMAL128);

            default:
                return null;
        }
    }

    enum Operation {

        PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

        private final String symbol;

        private Operation(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}

/*
 * UriComponentsBuilder targetPath = UriComponentsBuilder.newInstance() //
 * .path("/calculate") // .queryParam("n1", n1) // .queryParam("n2", n2) //
 * .queryParam("op", op) // .queryParam("result", result) // ;
 *
 * return "redirect:" + targetPath.toUriString();
 */