function sendFormatRequest(url) {
    jQuery.ajax({
        url: url,
        data: { pattern: jQuery('#inputFormat').val(),
                locale: jQuery('#inputLocale').val(),
                timeZone: jQuery('#inputTimeZone').val() },
        success: function(result) {
            jQuery('#result').text(result.value);
            if (result.error) {
                jQuery('#result').addClass('error');
            } else {
                jQuery('#result').removeClass('error');
            }
        }
    });
}