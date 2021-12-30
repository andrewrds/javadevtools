function sendFormatRequest(url) {
	let locale = jQuery('#inputLocale').val();
	let colonIndex = locale.indexOf(':');
	if (colonIndex != -1) {
		locale = locale.substring(0, colonIndex);
	}
	
    jQuery.ajax({
        url: url,
        data: { pattern: jQuery('#inputFormat').val(),
                locale: locale,
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