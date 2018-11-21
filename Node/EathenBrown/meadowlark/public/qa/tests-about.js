suite('"About" Page Tests', () => {
    test('Page should contain Link to Contact Page', () => {
        assert($('a[href="/contact"]').length);
    });
});