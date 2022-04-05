#!/usr/bin/env perl

use v5.10;

use strict;
use warnings;

use Data::Dumper;

my %dic;

open DIC, "<", "src/main/resources/messages_en.properties" or die "Could not open src/main/resources/messages_en.properties $!";

while(<DIC>) {
	chomp;
	@_ = split /\s*=\s*/;
	next unless $#_ > 0;
	$dic{$_[0]} = $_[1];
}

close DIC;

#say Dumper(\%dic);

while(<>) {
	chomp;
	while(/#\{(.*?)\}/g) {
		my $text = $1;
		say "$text = " unless defined $dic{$text};
	}
	while(/LocalFlash\("([^"]+)"/g) {
		my $text = $1;
		say "$text = " unless defined $dic{$text};
	}
}
